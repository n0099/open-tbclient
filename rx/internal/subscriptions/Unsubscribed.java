package rx.internal.subscriptions;

import com.baidu.tieba.p7b;
/* loaded from: classes10.dex */
public enum Unsubscribed implements p7b {
    INSTANCE;

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
    }
}
