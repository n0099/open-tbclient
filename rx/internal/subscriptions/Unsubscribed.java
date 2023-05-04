package rx.internal.subscriptions;

import com.baidu.tieba.q5b;
/* loaded from: classes9.dex */
public enum Unsubscribed implements q5b {
    INSTANCE;

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
    }
}
