package rx.internal.subscriptions;

import com.baidu.tieba.w7c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements w7c {
    INSTANCE;

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
    }
}
