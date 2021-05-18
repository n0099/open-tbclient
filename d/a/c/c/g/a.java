package d.a.c.c.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a {
    public HttpMessageListener mHttpMessageListener = null;
    public c mSocketMessageListener = null;

    /* renamed from: d.a.c.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0495a extends HttpMessageListener {
        public C0495a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.onMessage(httpResponsedMessage);
        }
    }

    /* loaded from: classes.dex */
    public class b extends c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            a.this.onMessage(socketResponsedMessage);
        }
    }

    public a(int i2, int i3, int i4) {
        init(i2, i3, i4);
    }

    private void init(int i2, int i3, int i4) {
        this.mHttpMessageListener = new C0495a(i2);
        this.mSocketMessageListener = new b(i3);
    }

    public HttpMessageListener getHttpMessageListener() {
        return this.mHttpMessageListener;
    }

    public c getSocketMessageListener() {
        return this.mSocketMessageListener;
    }

    public BdUniqueId getTag() {
        if (this.mHttpMessageListener.getTag() == this.mSocketMessageListener.getTag()) {
            return this.mHttpMessageListener.getTag();
        }
        throw new InvalidParameterException("tag invalid");
    }

    public abstract void onMessage(ResponsedMessage<?> responsedMessage);

    public void setTag(BdUniqueId bdUniqueId) {
        this.mHttpMessageListener.setTag(bdUniqueId);
        this.mSocketMessageListener.setTag(bdUniqueId);
    }

    public a(int i2, int i3) {
        init(i2, i3, 0);
    }
}
