package d.a.c.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class j extends g<SocketResponsedMessage> {
    public j(int i2) {
        super(i2);
        if (i2 != 0 && FrameHelper.e(i2) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
