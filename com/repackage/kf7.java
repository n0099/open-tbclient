package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes6.dex */
public interface kf7<T extends ICardInfo> {
    void c(BdUniqueId bdUniqueId);

    void d();

    void f();

    void g();

    void h();

    void setAfterClickSchemeListener(oe7 oe7Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
