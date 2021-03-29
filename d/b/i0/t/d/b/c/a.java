package d.b.i0.t.d.b.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60264a = 3;

    /* renamed from: b  reason: collision with root package name */
    public Context f60265b;

    /* renamed from: c  reason: collision with root package name */
    public View f60266c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f60267d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60268e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60269f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60270g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60271h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public View m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public List<FunctionListInfo> t;

    /* renamed from: d.b.i0.t.d.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1539a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f60272e;

        public View$OnClickListenerC1539a(FunctionListInfo functionListInfo) {
            this.f60272e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k(1, this.f60272e.url);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.f60265b);
                return;
            }
            a aVar = a.this;
            aVar.n("prefer_key_history", aVar.m);
            a.this.f60265b.startActivity(new Intent(a.this.f60265b, AlaRecentHistoryActivity.class));
            TiebaStatic.log("c12648");
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f60275e;

        public c(FunctionListInfo functionListInfo) {
            this.f60275e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k(3, this.f60275e.url);
            a aVar = a.this;
            aVar.n("prefer_key_activity", aVar.r);
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60265b = tbPageContext.getPageActivity();
        j();
    }

    public void f(List<FunctionListInfo> list) {
        this.t = list;
        for (FunctionListInfo functionListInfo : list) {
            if (functionListInfo != null) {
                int intValue = functionListInfo.id.intValue();
                if (intValue == 1) {
                    this.f60268e.setVisibility(0);
                    if (!TextUtils.isEmpty(functionListInfo.title)) {
                        this.f60270g.setText(functionListInfo.title);
                    }
                    if (!TextUtils.isEmpty(functionListInfo.describe)) {
                        this.f60271h.setVisibility(0);
                        this.f60271h.setText(functionListInfo.describe);
                    }
                    this.f60268e.setOnClickListener(new View$OnClickListenerC1539a(functionListInfo));
                } else if (intValue == 2) {
                    this.i.setVisibility(0);
                    if (!TextUtils.isEmpty(functionListInfo.title)) {
                        this.k.setText(functionListInfo.title);
                    }
                    if (!TextUtils.isEmpty(functionListInfo.describe)) {
                        this.l.setVisibility(0);
                        this.l.setText(functionListInfo.describe);
                    }
                    i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.m);
                    this.i.setOnClickListener(new b());
                } else if (intValue == 3) {
                    this.n.setVisibility(0);
                    if (!TextUtils.isEmpty(functionListInfo.title)) {
                        this.p.setText(functionListInfo.title);
                    }
                    if (!TextUtils.isEmpty(functionListInfo.describe)) {
                        this.q.setVisibility(0);
                        this.q.setText(functionListInfo.describe);
                    }
                    i(functionListInfo.id.intValue(), functionListInfo.update_time.longValue(), this.r);
                    this.n.setOnClickListener(new c(functionListInfo));
                }
            }
        }
        TiebaStatic.log("c12647");
    }

    public final long g(String str) {
        return d.b.h0.r.d0.b.i().k(str, 0L);
    }

    public View h() {
        return this.f60266c;
    }

    public final void i(int i, long j, View view) {
        if (g(i != 2 ? i != 3 ? null : "prefer_key_activity" : "prefer_key_history") < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final void j() {
        View inflate = LayoutInflater.from(this.f60265b).inflate(R.layout.square_live_function_region_layout, (ViewGroup) null);
        this.f60266c = inflate;
        this.f60267d = (LinearLayout) inflate.findViewById(R.id.square_function_container);
        LinearLayout linearLayout = (LinearLayout) this.f60266c.findViewById(R.id.square_function_rank);
        this.f60268e = linearLayout;
        linearLayout.setVisibility(8);
        this.f60269f = (ImageView) this.f60266c.findViewById(R.id.square_function_rank_img);
        this.f60270g = (TextView) this.f60266c.findViewById(R.id.square_function_rank_title);
        this.f60271h = (TextView) this.f60266c.findViewById(R.id.square_function_rank_desc);
        LinearLayout linearLayout2 = (LinearLayout) this.f60266c.findViewById(R.id.square_function_history);
        this.i = linearLayout2;
        linearLayout2.setVisibility(8);
        this.j = (ImageView) this.f60266c.findViewById(R.id.square_function_history_img);
        this.k = (TextView) this.f60266c.findViewById(R.id.square_function_history_title);
        this.l = (TextView) this.f60266c.findViewById(R.id.square_function_history_desc);
        this.m = this.f60266c.findViewById(R.id.square_function_history_red_pointer);
        LinearLayout linearLayout3 = (LinearLayout) this.f60266c.findViewById(R.id.square_function_activity);
        this.n = linearLayout3;
        linearLayout3.setVisibility(8);
        this.o = (ImageView) this.f60266c.findViewById(R.id.square_function_activity_img);
        this.p = (TextView) this.f60266c.findViewById(R.id.square_function_activity_title);
        this.q = (TextView) this.f60266c.findViewById(R.id.square_function_activity_desc);
        this.r = this.f60266c.findViewById(R.id.square_function_activity_red_pointer);
        this.s = this.f60266c.findViewById(R.id.square_function_bottom_space);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void k(int i, String str) {
        TiebaStatic.log(new StatisticItem("c12215"));
        d.b.h0.l.a.l(this.f60265b, str);
        if (3 == i) {
            TiebaStatic.log("c12649");
        } else if (1 == i) {
            TiebaStatic.log("c12215");
        }
    }

    public void l(int i) {
        if (this.f60264a != i) {
            this.f60264a = i;
            SkinManager.setBackgroundResource(this.f60267d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f60269f, R.drawable.live_portal_rank);
            SkinManager.setViewTextColor(this.f60270g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60271h, R.color.CAM_X0109);
            SkinManager.setImageResource(this.j, R.drawable.live_import_history);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            SkinManager.setImageResource(this.o, R.drawable.live_import_activity);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
        }
    }

    public void m() {
    }

    public final void n(String str, View view) {
        d.b.h0.r.d0.b.i().v(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }
}
