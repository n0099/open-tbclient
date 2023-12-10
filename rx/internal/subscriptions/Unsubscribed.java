package rx.internal.subscriptions;

import com.baidu.tieba.loc;
/* loaded from: classes2.dex */
public enum Unsubscribed implements loc {
    INSTANCE;

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
    }
}
