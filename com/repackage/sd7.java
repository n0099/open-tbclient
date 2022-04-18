package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes7.dex */
public interface sd7<T extends ICardInfo> {
    void b(BdUniqueId bdUniqueId);

    void e();

    void f();

    void g();

    void h();

    void setAfterClickSchemeListener(vc7 vc7Var);

    void setBusinessType(int i);

    void setDownloadAppCallback(xc7 xc7Var);

    void setFromCDN(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
