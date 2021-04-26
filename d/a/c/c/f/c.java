package d.a.c.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c extends g<HttpResponsedMessage> {
    public c(int i2) {
        super(i2);
        if (i2 != 0 && FrameHelper.e(i2) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
