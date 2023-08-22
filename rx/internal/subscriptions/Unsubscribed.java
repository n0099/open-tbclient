package rx.internal.subscriptions;

import com.baidu.tieba.u7c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements u7c {
    INSTANCE;

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
    }
}
