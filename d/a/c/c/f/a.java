package d.a.c.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a extends g<CustomResponsedMessage<?>> {
    public a(int i2) {
        super(i2);
        if (i2 != 0 && FrameHelper.e(i2) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
