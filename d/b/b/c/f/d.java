package d.b.b.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class d extends f<HttpMessage, HttpMessageTask> {
    public d(int i) {
        super(i);
        if (i != 0 && FrameHelper.e(i) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
