package d.a.k0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.a.j0.r.q.w1;
/* loaded from: classes4.dex */
public class g implements d.a.c.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52723e;

    /* renamed from: f  reason: collision with root package name */
    public String f52724f;

    /* renamed from: g  reason: collision with root package name */
    public int f52725g;

    /* renamed from: h  reason: collision with root package name */
    public int f52726h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52727i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f52723e = forumData.getName();
        this.f52724f = forumData.getImage_url();
        this.f52725g = forumData.getPost_num();
        this.f52726h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public g(w1 w1Var) {
        if (w1Var == null) {
            return;
        }
        this.f52723e = w1Var.f50114b;
        this.f52724f = w1Var.f50115c;
        this.f52725g = w1Var.f50120h;
        this.f52726h = w1Var.f50121i;
        this.j = w1Var.f50113a;
    }
}
