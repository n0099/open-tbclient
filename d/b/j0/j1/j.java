package d.b.j0.j1;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import d.b.j0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f57752a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f57753b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f57754c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f57755d;

    /* renamed from: e  reason: collision with root package name */
    public final View f57756e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f57757f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f57758g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f57759h;
    public final TbImageView i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f57761f;

        public a(String str, String str2) {
            this.f57760e = str;
            this.f57761f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f57760e, this.f57761f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f57763e;

        public b(List list) {
            this.f57763e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f57763e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57765e;

        public c(String str) {
            this.f57765e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f57765e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.j1.p.d f57767e;

        public d(d.b.j0.j1.p.d dVar) {
            this.f57767e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f57767e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f57769e;

        public e(ShareItem shareItem) {
            this.f57769e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f57769e.t);
            d.b.c.e.p.l.L(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f57752a = navigationBar;
        this.f57756e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f57753b = (RelativeLayout) this.f57752a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f57752a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f57754c = (TextView) this.f57753b.findViewById(R.id.lego_title);
        this.f57755d = (TbImageView) this.f57753b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f57753b.findViewById(R.id.ll_right);
        this.f57757f = linearLayout;
        this.f57758g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f57759h = (TbImageView) this.f57757f.findViewById(R.id.iv2);
        this.i = (TbImageView) this.f57757f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f57758g);
        this.j.add(this.f57759h);
        this.j.add(this.i);
    }

    public void d() {
        this.f57752a.setVisibility(8);
    }

    public final void e(List<d.b.j0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f57757f.setVisibility(0);
        for (int i = 0; i < list.size() && i < this.j.size(); i++) {
            this.j.get(i).setVisibility(0);
            if (list.get(i).f57894d == 2) {
                SkinManager.setImageResource(this.j.get(i), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i).W(list.get(i).f57892b, 10, false);
            } else {
                this.j.get(i).W(list.get(i).f57891a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i).f57893c)) {
                String str = list.get(i).f57893c;
                if (list.get(i).f57894d == 1) {
                    this.j.get(i).setOnClickListener(new c(str));
                } else if (list.get(i).f57894d == 2) {
                    this.j.get(i).setOnClickListener(new d(list.get(i)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f57755d;
        if (tbImageView == null || this.f57754c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f57754c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f57755d.W(str2, 10, false);
        } else {
            this.f57755d.W(str, 10, false);
        }
    }

    public void g(List<d.b.j0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f57757f.setVisibility(8);
            return;
        }
        e(list);
        this.f57757f.postDelayed(new b(list), 1000L);
    }

    public void h(d.b.j0.j1.p.d dVar) {
        if (dVar == null || dVar.f57894d != 2) {
            return;
        }
        String str = dVar.f57897g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f57895e;
        shareItem.s = dVar.f57896f;
        shareItem.t = dVar.f57893c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f57754c, R.color.CAM_X0105);
        this.f57754c.setVisibility(0);
        this.f57755d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f57754c.setText(str);
        } else {
            this.f57754c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f57755d.postDelayed(new a(str, str2), 1000L);
    }
}
