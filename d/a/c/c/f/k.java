package d.a.c.c.f;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class k extends f<SocketMessage, SocketMessageTask> {
    public k(int i2) {
        super(i2);
        if (i2 != 0 && FrameHelper.e(i2) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
