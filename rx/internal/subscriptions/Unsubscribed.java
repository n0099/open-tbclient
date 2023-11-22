package rx.internal.subscriptions;

import com.baidu.tieba.qjc;
/* loaded from: classes2.dex */
public enum Unsubscribed implements qjc {
    INSTANCE;

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
    }
}
