package d.a.k0.j1;

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
import d.a.k0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f56423a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f56424b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f56425c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f56426d;

    /* renamed from: e  reason: collision with root package name */
    public final View f56427e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f56428f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f56429g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f56430h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f56431i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f56432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f56433f;

        public a(String str, String str2) {
            this.f56432e = str;
            this.f56433f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f56432e, this.f56433f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f56435e;

        public b(List list) {
            this.f56435e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f56435e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f56437e;

        public c(String str) {
            this.f56437e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f56437e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.j1.p.d f56439e;

        public d(d.a.k0.j1.p.d dVar) {
            this.f56439e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f56439e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f56441e;

        public e(ShareItem shareItem) {
            this.f56441e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f56441e.t);
            d.a.c.e.p.l.M(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f56423a = navigationBar;
        this.f56427e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f56424b = (RelativeLayout) this.f56423a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f56423a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f56425c = (TextView) this.f56424b.findViewById(R.id.lego_title);
        this.f56426d = (TbImageView) this.f56424b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f56424b.findViewById(R.id.ll_right);
        this.f56428f = linearLayout;
        this.f56429g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f56430h = (TbImageView) this.f56428f.findViewById(R.id.iv2);
        this.f56431i = (TbImageView) this.f56428f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f56429g);
        this.j.add(this.f56430h);
        this.j.add(this.f56431i);
    }

    public void d() {
        this.f56423a.setVisibility(8);
    }

    public final void e(List<d.a.k0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f56428f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f56573d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).V(list.get(i2).f56571b, 10, false);
            } else {
                this.j.get(i2).V(list.get(i2).f56570a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f56572c)) {
                String str = list.get(i2).f56572c;
                if (list.get(i2).f56573d == 1) {
                    this.j.get(i2).setOnClickListener(new c(str));
                } else if (list.get(i2).f56573d == 2) {
                    this.j.get(i2).setOnClickListener(new d(list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f56426d;
        if (tbImageView == null || this.f56425c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f56425c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f56426d.V(str2, 10, false);
        } else {
            this.f56426d.V(str, 10, false);
        }
    }

    public void g(List<d.a.k0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f56428f.setVisibility(8);
            return;
        }
        e(list);
        this.f56428f.postDelayed(new b(list), 1000L);
    }

    public void h(d.a.k0.j1.p.d dVar) {
        if (dVar == null || dVar.f56573d != 2) {
            return;
        }
        String str = dVar.f56576g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f56574e;
        shareItem.s = dVar.f56575f;
        shareItem.t = dVar.f56572c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f56425c, R.color.CAM_X0105);
        this.f56425c.setVisibility(0);
        this.f56426d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f56425c.setText(str);
        } else {
            this.f56425c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f56426d.postDelayed(new a(str, str2), 1000L);
    }
}
