package d.b.i0.j1;

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
import d.b.i0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f57331a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f57332b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f57333c;

    /* renamed from: d  reason: collision with root package name */
    public final TbImageView f57334d;

    /* renamed from: e  reason: collision with root package name */
    public final View f57335e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f57336f;

    /* renamed from: g  reason: collision with root package name */
    public final TbImageView f57337g;

    /* renamed from: h  reason: collision with root package name */
    public final TbImageView f57338h;
    public final TbImageView i;
    public final List<TbImageView> j;
    public LegoListActivity k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f57340f;

        public a(String str, String str2) {
            this.f57339e = str;
            this.f57340f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f(this.f57339e, this.f57340f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f57342e;

        public b(List list) {
            this.f57342e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e(this.f57342e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57344e;

        public c(String str) {
            this.f57344e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(j.this.k.getPageContext(), this.f57344e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.j1.p.d f57346e;

        public d(d.b.i0.j1.p.d dVar) {
            this.f57346e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.h(this.f57346e);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f57348e;

        public e(ShareItem shareItem) {
            this.f57348e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.c.e.p.a.a(this.f57348e.t);
            d.b.c.e.p.l.L(j.this.k.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    public j(LegoListActivity legoListActivity) {
        this.k = legoListActivity;
        NavigationBar navigationBar = (NavigationBar) legoListActivity.findViewById(R.id.view_navigation_bar);
        this.f57331a = navigationBar;
        this.f57335e = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.mCommonOnClickListener);
        this.f57332b = (RelativeLayout) this.f57331a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.f57331a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.f57333c = (TextView) this.f57332b.findViewById(R.id.lego_title);
        this.f57334d = (TbImageView) this.f57332b.findViewById(R.id.lego_title_img);
        LinearLayout linearLayout = (LinearLayout) this.f57332b.findViewById(R.id.ll_right);
        this.f57336f = linearLayout;
        this.f57337g = (TbImageView) linearLayout.findViewById(R.id.iv1);
        this.f57338h = (TbImageView) this.f57336f.findViewById(R.id.iv2);
        this.i = (TbImageView) this.f57336f.findViewById(R.id.iv3);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        arrayList.add(this.f57337g);
        this.j.add(this.f57338h);
        this.j.add(this.i);
    }

    public void d() {
        this.f57331a.setVisibility(8);
    }

    public final void e(List<d.b.i0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f57336f.setVisibility(0);
        for (int i = 0; i < list.size() && i < this.j.size(); i++) {
            this.j.get(i).setVisibility(0);
            if (list.get(i).f57473d == 2) {
                SkinManager.setImageResource(this.j.get(i), R.drawable.icon_nav_share_n);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.j.get(i).W(list.get(i).f57471b, 10, false);
            } else {
                this.j.get(i).W(list.get(i).f57470a, 10, false);
            }
            if (!TextUtils.isEmpty(list.get(i).f57472c)) {
                String str = list.get(i).f57472c;
                if (list.get(i).f57473d == 1) {
                    this.j.get(i).setOnClickListener(new c(str));
                } else if (list.get(i).f57473d == 2) {
                    this.j.get(i).setOnClickListener(new d(list.get(i)));
                }
            }
        }
        for (int size = list.size(); size < this.j.size(); size++) {
            this.j.get(size).setVisibility(8);
        }
    }

    public final void f(String str, String str2) {
        TbImageView tbImageView = this.f57334d;
        if (tbImageView == null || this.f57333c == null) {
            return;
        }
        tbImageView.setVisibility(0);
        this.f57333c.setVisibility(8);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f57334d.W(str2, 10, false);
        } else {
            this.f57334d.W(str, 10, false);
        }
    }

    public void g(List<d.b.i0.j1.p.d> list) {
        if (ListUtils.isEmpty(list)) {
            this.f57336f.setVisibility(8);
            return;
        }
        e(list);
        this.f57336f.postDelayed(new b(list), 1000L);
    }

    public void h(d.b.i0.j1.p.d dVar) {
        if (dVar == null || dVar.f57473d != 2) {
            return;
        }
        String str = dVar.f57476g;
        Uri parse = str == null ? null : Uri.parse(str);
        ShareItem shareItem = new ShareItem();
        shareItem.r = dVar.f57474e;
        shareItem.s = dVar.f57475f;
        shareItem.t = dVar.f57472c;
        if (parse != null) {
            shareItem.v = parse;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.k.getActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new e(shareItem));
        this.k.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public void i(String str) {
        SkinManager.setViewTextColor(this.f57333c, R.color.CAM_X0105);
        this.f57333c.setVisibility(0);
        this.f57334d.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f57333c.setText(str);
        } else {
            this.f57333c.setText("");
        }
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f(str, str2);
        this.f57334d.postDelayed(new a(str, str2), 1000L);
    }
}
