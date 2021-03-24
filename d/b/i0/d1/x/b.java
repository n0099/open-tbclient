package d.b.i0.d1.x;

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
public class b extends d.b.b.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54075b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54076c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54077d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54078e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54079f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54080g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f54081h;
    public ValidateItemData i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54081h.onItemViewClick(b.this.f54080g, 100, 0, 0L, b.this.i);
        }
    }

    /* renamed from: d.b.i0.d1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1214b implements View.OnClickListener {
        public View$OnClickListenerC1214b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54081h.onItemViewClick(b.this.f54076c, 101, 0, 0L, b.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f54081h.onItemViewLongClick(b.this.f54075b, 200, 0, 0L, b.this.i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f54081h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f41468a.findViewById(R.id.root_view);
        this.f54075b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f54076c = headImageView;
        headImageView.setIsRound(false);
        this.f54077d = (TextView) this.f54075b.findViewById(R.id.tv_user_name);
        this.f54078e = (TextView) this.f54075b.findViewById(R.id.tv_group_name);
        this.f54079f = (TextView) this.f54075b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f54075b.findViewById(R.id.btn_pass);
        this.f54080g = textView;
        textView.setOnClickListener(new a());
        this.f54076c.setOnClickListener(new View$OnClickListenerC1214b());
        this.f54075b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.i = validateItemData;
    }

    public void refresh() {
        if (this.i == null) {
            return;
        }
        this.f54081h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54081h.getLayoutMode().j(this.f54075b);
        String portrait = this.i.getPortrait();
        this.f54076c.setTag(portrait);
        this.f54076c.W(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.f54077d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.f54078e;
            textView.setText(this.f54081h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f54079f;
            textView2.setText(this.f54081h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.f54080g.setEnabled(false);
            this.f54080g.setText(this.f54081h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f54080g, R.color.CAM_X0109);
            this.f54080g.setBackgroundDrawable(null);
        } else {
            this.f54080g.setEnabled(true);
            this.f54080g.setText(this.f54081h.getPageContext().getString(R.string.pass));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f54075b, R.color.common_color_10178);
    }
}
