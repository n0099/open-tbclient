package d.a.c.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b extends f<CustomMessage<?>, CustomMessageTask> {
    public b(int i2) {
        super(i2);
        if (i2 != 0 && FrameHelper.e(i2) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
