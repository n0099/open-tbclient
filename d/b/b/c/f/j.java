package d.b.b.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class j extends g<SocketResponsedMessage> {
    public j(int i) {
        super(i);
        if (i != 0 && FrameHelper.e(i) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
