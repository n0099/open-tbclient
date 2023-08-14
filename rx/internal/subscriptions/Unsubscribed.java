package rx.internal.subscriptions;

import com.baidu.tieba.f1c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements f1c {
    INSTANCE;

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
    }
}
