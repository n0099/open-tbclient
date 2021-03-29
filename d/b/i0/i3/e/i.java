package d.b.i0.i3.e;

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
    public BackgroundPreviewActivity f56289a;

    /* renamed from: b  reason: collision with root package name */
    public View f56290b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f56291c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f56292d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f56293e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56294f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56295g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56296h;
    public final d.b.b.e.l.c<d.b.b.j.d.a> i = new a();

    /* loaded from: classes5.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public a() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.b.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.h(i.this.f56291c);
            }
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        this.f56289a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f56290b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f56289a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        return this.f56290b;
    }

    public final void c() {
        this.f56291c = (BdExpandImageView) this.f56290b.findViewById(R.id.expand_image);
        this.f56292d = (TbImageView) this.f56290b.findViewById(R.id.user_head);
        TbImageView tbImageView = (TbImageView) this.f56290b.findViewById(R.id.vip_icon);
        this.f56293e = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.f56294f = (TextView) this.f56290b.findViewById(R.id.user_name);
        this.f56295g = (ImageView) this.f56290b.findViewById(R.id.user_sex);
        this.f56296h = (TextView) this.f56290b.findViewById(R.id.user_bar_age_num);
        this.f56292d.setDefaultResource(R.drawable.icon_default_avatar100);
    }

    public void d() {
        if (this.f56289a.getPageContext() == null) {
            return;
        }
        d.b.h0.s0.a.a(this.f56289a.getPageContext(), this.f56290b);
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        d.b.b.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f56296h.setText("0");
        } else {
            this.f56296h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f56296h, R.color.CAM_X0308, 1);
            this.f56294f.setText(R.string.default_user_name);
            this.f56295g.setImageResource(R.drawable.icon_pop_boy);
            this.f56293e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f56292d.W(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f56293e.setVisibility(8);
        } else {
            this.f56293e.W(memberIconUrl, 10, false);
            this.f56293e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f56294f.setTextColor(this.f56289a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f56294f.setTextColor(this.f56289a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f56294f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f56295g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f56295g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f56295g.setVisibility(8);
        }
    }
}
