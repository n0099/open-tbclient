package d.a.o0.k1;

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
import d.a.o0.e3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f60417a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f60418b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f60419c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f60420d;

    /* renamed from: e  reason: collision with root package name */
    public final View f60421e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f60422f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f60423g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f60424h;

    /* renamed from: i  reason: collision with root package name */
    public final TbImageView f60425i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60427f;

        public a(String str, String str2) {
            this.f60426e = str;
            this.f60427f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f60426e, this.f60427f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f60429e;

        public b(List list) {
            this.f60429e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f60429e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60431e;

        public c(String str) {
            this.f60431e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f60431e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.k1.p.d f60433e;

        public d(d.a.o0.k1.p.d dVar) {
            this.f60433e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f60433e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f60435e;

        public e(ShareItem shareItem) {
            this.f60435e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f60435e.t);
            d.a.c.e.p.l.M(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f60417a = navigationBar;
        this.f60421e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f60418b = (RelativeLayout) this.f60417a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f60417a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f60419c = (TextView) this.f60418b.findViewById(R.id.lego_title);
        this.f60420d = (TbImageView) this.f60418b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f60418b.findViewById(R.id.ll_right);
        this.f60422f = linearLayout;
        this.f60423g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f60424h = (TbImageView) this.f60422f.findViewById(R.id.iv2);
        this.f60425i = (TbImageView) this.f60422f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f60423g);
        this.j.add(this.f60424h);
        this.j.add(this.f60425i);
    }

    public void d() {
        this.f60417a.setVisibility(8);
    }

    public final void e(List<d.a.o0.k1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f60422f.setVisibility(0);
        for (int i2 = 0; i2 < list.size() && i2 < this.j.size(); i2++) {
            this.j.get(i2).setVisibility(0);
            if (list.get(i2).f60567d == 2) {
                SkinManager.setImageResource(this.j.get(i2), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i2).U(list.get(i2).f60565b, 10, false);
            } else {
                this.j.get(i2).U(list.get(i2).f60564a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i2).f60566c)) {
                String str = list.get(i2).f60566c;
                if (list.get(i2).f60567d == 1) {
                    this.j.get(i2).setOnClickListener(new c(str));
                } else if (list.get(i2).f60567d == 2) {
                    this.j.get(i2).setOnClickListener(new d(list.get(i2)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f60420d;
        if (tbImageView == null || this.f60419c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f60419c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f60420d.U(str2, 10, false);
        } else {
            this.f60420d.U(str, 10, false);
        }
    }

    public void g(List<d.a.o0.k1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f60422f.setVisibility(8);
            return;
        }
        e(list);
        this.f60422f.postDelayed(new b(list), 1000L);
    }

    public void h(d.a.o0.k1.p.d dVar) {
        if (dVar == null || dVar.f60567d != 2) {
            return;
        }
        String str = dVar.f60570g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f60568e;
        shareItem.s = dVar.f60569f;
        shareItem.t = dVar.f60566c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f60419c, R.color.CAM_X0105);
        this.f60419c.setVisibility(0);
        this.f60420d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f60419c.setText(str);
        } else {
            this.f60419c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f60420d.postDelayed(new a(str, str2), 1000L);
    }
}
