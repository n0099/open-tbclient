package d.b.j0.t.d.b.c;

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
    public int f62249a = 3;

    /* renamed from: b  reason: collision with root package name */
    public Context f62250b;

    /* renamed from: c  reason: collision with root package name */
    public View f62251c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f62252d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f62253e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62254f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62255g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62256h;
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

    /* renamed from: d.b.j0.t.d.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1615a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f62257e;

        public View$OnClickListenerC1615a(FunctionListInfo functionListInfo) {
            this.f62257e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k(1, this.f62257e.url);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(a.this.f62250b);
                return;
            }
            a aVar = a.this;
            aVar.n("prefer_key_history", aVar.m);
            a.this.f62250b.startActivity(new Intent(a.this.f62250b, AlaRecentHistoryActivity.class));
            TiebaStatic.log("c12648");
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FunctionListInfo f62260e;

        public c(FunctionListInfo functionListInfo) {
            this.f62260e = functionListInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k(3, this.f62260e.url);
            a aVar = a.this;
            aVar.n("prefer_key_activity", aVar.r);
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f62250b = tbPageContext.getPageActivity();
        j();
    }

    public void f(List<FunctionListInfo> list) {
        this.t = list;
        for (FunctionListInfo functionListInfo : list) {
            if (functionListInfo != null) {
                int intValue = functionListInfo.id.intValue();
                if (intValue == 1) {
                    this.f62253e.setVisibility(0);
                    if (!TextUtils.isEmpty(functionListInfo.title)) {
                        this.f62255g.setText(functionListInfo.title);
                    }
                    if (!TextUtils.isEmpty(functionListInfo.describe)) {
                        this.f62256h.setVisibility(0);
                        this.f62256h.setText(functionListInfo.describe);
                    }
                    this.f62253e.setOnClickListener(new View$OnClickListenerC1615a(functionListInfo));
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
        return d.b.i0.r.d0.b.j().l(str, 0L);
    }

    public View h() {
        return this.f62251c;
    }

    public final void i(int i, long j, View view) {
        if (g(i != 2 ? i != 3 ? null : "prefer_key_activity" : "prefer_key_history") < j) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final void j() {
        View inflate = LayoutInflater.from(this.f62250b).inflate(R.layout.square_live_function_region_layout, (ViewGroup) null);
        this.f62251c = inflate;
        this.f62252d = (LinearLayout) inflate.findViewById(R.id.square_function_container);
        LinearLayout linearLayout = (LinearLayout) this.f62251c.findViewById(R.id.square_function_rank);
        this.f62253e = linearLayout;
        linearLayout.setVisibility(8);
        this.f62254f = (ImageView) this.f62251c.findViewById(R.id.square_function_rank_img);
        this.f62255g = (TextView) this.f62251c.findViewById(R.id.square_function_rank_title);
        this.f62256h = (TextView) this.f62251c.findViewById(R.id.square_function_rank_desc);
        LinearLayout linearLayout2 = (LinearLayout) this.f62251c.findViewById(R.id.square_function_history);
        this.i = linearLayout2;
        linearLayout2.setVisibility(8);
        this.j = (ImageView) this.f62251c.findViewById(R.id.square_function_history_img);
        this.k = (TextView) this.f62251c.findViewById(R.id.square_function_history_title);
        this.l = (TextView) this.f62251c.findViewById(R.id.square_function_history_desc);
        this.m = this.f62251c.findViewById(R.id.square_function_history_red_pointer);
        LinearLayout linearLayout3 = (LinearLayout) this.f62251c.findViewById(R.id.square_function_activity);
        this.n = linearLayout3;
        linearLayout3.setVisibility(8);
        this.o = (ImageView) this.f62251c.findViewById(R.id.square_function_activity_img);
        this.p = (TextView) this.f62251c.findViewById(R.id.square_function_activity_title);
        this.q = (TextView) this.f62251c.findViewById(R.id.square_function_activity_desc);
        this.r = this.f62251c.findViewById(R.id.square_function_activity_red_pointer);
        this.s = this.f62251c.findViewById(R.id.square_function_bottom_space);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void k(int i, String str) {
        TiebaStatic.log(new StatisticItem("c12215"));
        d.b.i0.l.a.l(this.f62250b, str);
        if (3 == i) {
            TiebaStatic.log("c12649");
        } else if (1 == i) {
            TiebaStatic.log("c12215");
        }
    }

    public void l(int i) {
        if (this.f62249a != i) {
            this.f62249a = i;
            SkinManager.setBackgroundResource(this.f62252d, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f62254f, R.drawable.live_portal_rank);
            SkinManager.setViewTextColor(this.f62255g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f62256h, R.color.CAM_X0109);
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
        d.b.i0.r.d0.b.j().w(str, System.currentTimeMillis() / 1000);
        view.setVisibility(8);
    }
}
