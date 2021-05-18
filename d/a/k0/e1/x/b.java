package d.a.k0.e1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54594b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54595c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54596d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54597e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54598f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54599g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f54600h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f54601i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54600h.onItemViewClick(b.this.f54599g, 100, 0, 0L, b.this.f54601i);
        }
    }

    /* renamed from: d.a.k0.e1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1312b implements View.OnClickListener {
        public View$OnClickListenerC1312b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54600h.onItemViewClick(b.this.f54595c, 101, 0, 0L, b.this.f54601i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f54600h.onItemViewLongClick(b.this.f54594b, 200, 0, 0L, b.this.f54601i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f54600h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f38636a.findViewById(R.id.root_view);
        this.f54594b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f54595c = headImageView;
        headImageView.setIsRound(false);
        this.f54596d = (TextView) this.f54594b.findViewById(R.id.tv_user_name);
        this.f54597e = (TextView) this.f54594b.findViewById(R.id.tv_group_name);
        this.f54598f = (TextView) this.f54594b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f54594b.findViewById(R.id.btn_pass);
        this.f54599g = textView;
        textView.setOnClickListener(new a());
        this.f54595c.setOnClickListener(new View$OnClickListenerC1312b());
        this.f54594b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.f54601i = validateItemData;
    }

    public void refresh() {
        if (this.f54601i == null) {
            return;
        }
        this.f54600h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54600h.getLayoutMode().j(this.f54594b);
        String portrait = this.f54601i.getPortrait();
        this.f54595c.setTag(portrait);
        this.f54595c.V(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f54601i.getUserName())) {
            this.f54596d.setText(this.f54601i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f54601i.getGroupName())) {
            TextView textView = this.f54597e;
            textView.setText(this.f54600h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f54601i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f54601i.getApplyReason())) {
            TextView textView2 = this.f54598f;
            textView2.setText(this.f54600h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f54601i.getApplyReason());
        }
        if (this.f54601i.isPass()) {
            this.f54599g.setEnabled(false);
            this.f54599g.setText(this.f54600h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f54599g, R.color.CAM_X0109);
            this.f54599g.setBackgroundDrawable(null);
        } else {
            this.f54599g.setEnabled(true);
            this.f54599g.setText(this.f54600h.getPageContext().getString(R.string.pass));
        }
        if (this.f54601i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f54594b, R.color.common_color_10178);
    }
}
