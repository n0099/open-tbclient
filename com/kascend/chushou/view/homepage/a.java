package com.kascend.chushou.view.homepage;

import com.kascend.chushou.c.b;
import com.kascend.chushou.c.d;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.base.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a extends c<HomePageRecommendFragment> {
    public String c;
    final ArrayList<PannelItem> d = new ArrayList<>();
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, ArrayList<PannelItem> arrayList, int i) {
        if (!h.isEmpty(arrayList)) {
            this.d.clear();
            this.d.addAll(arrayList);
        }
        this.c = str;
        this.e = i;
    }

    public void c() {
        if (this.e == 0) {
            d();
        } else if (this.e == 1) {
            e();
        }
    }

    private void d() {
        com.kascend.chushou.c.c.dMl().a(new b() { // from class: com.kascend.chushou.view.homepage.a.1
            @Override // com.kascend.chushou.c.b
            public void a() {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(1);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(2);
                    ParserRet eb = d.eb(jSONObject);
                    if (eb.mRc == 0 && eb.mData1 != null) {
                        List list = (List) eb.mData1;
                        a.this.c = eb.mBreakpoint;
                        if (h.isEmpty(list)) {
                            ((HomePageRecommendFragment) a.this.b).showStatus(6);
                            return;
                        }
                        a.this.d.clear();
                        a.this.d.addAll(list);
                        ((HomePageRecommendFragment) a.this.b).updateUI(a.this.d);
                        return;
                    }
                    a(eb.mRc, eb.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(2);
                    ((HomePageRecommendFragment) a.this.b).showApiError(h.isEmpty(a.this.d), i, str);
                }
            }
        }, this.c, LoginManager.Instance().islogined());
    }

    private void e() {
        com.kascend.chushou.c.c.dMl().b(new b() { // from class: com.kascend.chushou.view.homepage.a.2
            @Override // com.kascend.chushou.c.b
            public void a() {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(1);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(2);
                    ParserRet eb = d.eb(jSONObject);
                    if (eb.mRc == 0 && eb.mData1 != null) {
                        List list = (List) eb.mData1;
                        a.this.c = eb.mBreakpoint;
                        if (h.isEmpty(list)) {
                            ((HomePageRecommendFragment) a.this.b).showStatus(6);
                            return;
                        }
                        a.this.d.clear();
                        a.this.d.addAll(list);
                        ((HomePageRecommendFragment) a.this.b).updateUI(a.this.d);
                        return;
                    }
                    a(eb.mRc, eb.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                if (a.this.b()) {
                    ((HomePageRecommendFragment) a.this.b).showStatus(2);
                    ((HomePageRecommendFragment) a.this.b).showApiError(h.isEmpty(a.this.d), i, str);
                }
            }
        }, this.c, LoginManager.Instance().islogined());
    }
}
