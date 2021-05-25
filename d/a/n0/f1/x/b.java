package d.a.n0.f1.x;

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
    public View f54784b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54785c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54786d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54787e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54788f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54789g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f54790h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f54791i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54790h.onItemViewClick(b.this.f54789g, 100, 0, 0L, b.this.f54791i);
        }
    }

    /* renamed from: d.a.n0.f1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1330b implements View.OnClickListener {
        public View$OnClickListenerC1330b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54790h.onItemViewClick(b.this.f54785c, 101, 0, 0L, b.this.f54791i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f54790h.onItemViewLongClick(b.this.f54784b, 200, 0, 0L, b.this.f54791i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f54790h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f38300a.findViewById(R.id.root_view);
        this.f54784b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f54785c = headImageView;
        headImageView.setIsRound(false);
        this.f54786d = (TextView) this.f54784b.findViewById(R.id.tv_user_name);
        this.f54787e = (TextView) this.f54784b.findViewById(R.id.tv_group_name);
        this.f54788f = (TextView) this.f54784b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f54784b.findViewById(R.id.btn_pass);
        this.f54789g = textView;
        textView.setOnClickListener(new a());
        this.f54785c.setOnClickListener(new View$OnClickListenerC1330b());
        this.f54784b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.f54791i = validateItemData;
    }

    public void refresh() {
        if (this.f54791i == null) {
            return;
        }
        this.f54790h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54790h.getLayoutMode().j(this.f54784b);
        String portrait = this.f54791i.getPortrait();
        this.f54785c.setTag(portrait);
        this.f54785c.V(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f54791i.getUserName())) {
            this.f54786d.setText(this.f54791i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f54791i.getGroupName())) {
            TextView textView = this.f54787e;
            textView.setText(this.f54790h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f54791i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f54791i.getApplyReason())) {
            TextView textView2 = this.f54788f;
            textView2.setText(this.f54790h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f54791i.getApplyReason());
        }
        if (this.f54791i.isPass()) {
            this.f54789g.setEnabled(false);
            this.f54789g.setText(this.f54790h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f54789g, R.color.CAM_X0109);
            this.f54789g.setBackgroundDrawable(null);
        } else {
            this.f54789g.setEnabled(true);
            this.f54789g.setText(this.f54790h.getPageContext().getString(R.string.pass));
        }
        if (this.f54791i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f54784b, R.color.common_color_10178);
    }
}
