package rx.internal.subscriptions;

import com.baidu.tieba.b2c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements b2c {
    INSTANCE;

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
    }
}
