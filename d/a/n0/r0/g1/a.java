package d.a.n0.r0.g1;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.z;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a implements z.d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58585a;

    /* renamed from: b  reason: collision with root package name */
    public View f58586b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58587c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58588d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58589e;

    /* renamed from: f  reason: collision with root package name */
    public b f58590f;

    /* renamed from: g  reason: collision with root package name */
    public z f58591g;

    /* renamed from: h  reason: collision with root package name */
    public View f58592h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f58593i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n = new View$OnClickListenerC1497a();

    /* renamed from: d.a.n0.r0.g1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1497a implements View.OnClickListener {
        public View$OnClickListenerC1497a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.j.getId()) {
                a.this.f58585a.getPageActivity().finish();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view) {
        this.f58585a = tbPageContext;
        this.f58586b = view;
        this.f58587c = (TextView) view.findViewById(R.id.to_user_name);
        this.f58588d = (TextView) view.findViewById(R.id.content);
        this.f58589e = (TextView) view.findViewById(R.id.sender);
        this.f58592h = view.findViewById(R.id.share_view);
        this.f58593i = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        this.j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_top);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int k = l.k(tbPageContext.getPageActivity()) - (l.g(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (((k * SDKLogTypeConstants.TYPE_FEED_CLICK) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view.findViewById(R.id.qr_view_intro);
        View findViewById = view.findViewById(R.id.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.f58592h.setBackground(f());
        b bVar = new b(tbPageContext);
        this.f58590f = bVar;
        bVar.k();
        i();
        z zVar = new z(tbPageContext);
        this.f58591g = zVar;
        zVar.o(view, this.f58592h, this);
        z zVar2 = this.f58591g;
        b bVar2 = this.f58590f;
        zVar2.q(bVar2.f58596b, bVar2.f58600f);
        this.f58591g.r(5);
    }

    @Override // d.a.n0.r0.z.d
    public void a() {
        this.f58592h.setBackground(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0201)));
        this.k.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
    }

    @Override // d.a.n0.r0.z.d
    public void b() {
        this.f58592h.setBackground(f());
        this.k.setImageResource(R.drawable.pic_yaoqinghan_980x364);
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.f58593i.setImageBitmap((Bitmap) runTask.getData());
    }

    public final GradientDrawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(R.color.CAM_X0201), SkinManager.getColor(R.color.CAM_X0201)});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(l.g(this.f58585a.getPageActivity(), R.dimen.tbds31));
        return gradientDrawable;
    }

    public void g(int i2) {
        SkinManager.setImageResource(this.j, R.drawable.icon_popup_shut_n);
        SkinManager.setViewTextColor(this.f58587c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58588d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58589e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
    }

    public void h(boolean z) {
        this.f58586b.setVisibility(z ? 0 : 8);
    }

    public final void i() {
        this.f58587c.setText("你好，朋友！");
        this.f58588d.setText(this.f58590f.h());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        TextView textView = this.f58589e;
        textView.setText(this.f58590f.f58598d + "\n" + simpleDateFormat.format(date));
        e(this.f58590f.f58597c);
    }
}
