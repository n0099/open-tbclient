package d.b.j0.j3.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f58157a;

    /* renamed from: b  reason: collision with root package name */
    public View f58158b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f58159c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f58160d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f58161e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58162f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58163g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58164h;
    public final d.b.c.e.l.c<d.b.c.j.d.a> i = new a();

    /* loaded from: classes5.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public a() {
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.h(i.this.f58159c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f58157a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f58158b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f58157a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f58158b;
    }

    public final void c() {
        this.f58159c = (BdExpandImageView) this.f58158b.findViewById(R.id.expand_image);
        this.f58160d = (TbImageView) this.f58158b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f58158b.findViewById(R.id.vip_icon);
        this.f58161e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f58162f = (TextView) this.f58158b.findViewById(R.id.user_name);
        this.f58163g = (ImageView) this.f58158b.findViewById(R.id.user_sex);
        this.f58164h = (TextView) this.f58158b.findViewById(R.id.user_bar_age_num);
        this.f58160d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f58157a.getPageContext() == null) {
            return;
        }
        d.b.i0.s0.a.a(this.f58157a.getPageContext(), this.f58158b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.b.c.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f58164h.setText("0");
        } else {
            this.f58164h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f58164h, R.color.CAM_X0308, 1);
            this.f58162f.setText(R.string.default_user_name);
            this.f58163g.setImageResource(R.drawable.icon_pop_boy);
            this.f58161e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f58160d.W(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f58161e.setVisibility(8);
        } else {
            this.f58161e.W(memberIconUrl, 10, false);
            this.f58161e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f58162f.setTextColor(this.f58157a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f58162f.setTextColor(this.f58157a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f58162f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f58163g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f58163g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f58163g.setVisibility(8);
        }
    }
}
