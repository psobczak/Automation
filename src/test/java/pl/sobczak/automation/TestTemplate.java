package pl.sobczak.automation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import pl.sobczak.automation.config.SeleniumTestCaseContext;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@TestExecutionListeners(value = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class}, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
public abstract class TestTemplate {


}
