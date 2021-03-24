package d.b.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
/* loaded from: classes.dex */
public interface f<T> {
    Context getContext();

    T getOrignalPage();

    Activity getPageActivity();

    Resources getResources();

    String getString(int i);

    BdUniqueId getUniqueId();

    void registerListener(MessageListener<?> messageListener);

    void sendMessage(Message<?> message);
}
