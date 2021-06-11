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
    public View f58473b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f58474c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58475d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58476e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58477f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58478g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f58479h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f58480i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58479h.onItemViewClick(b.this.f58478g, 100, 0, 0L, b.this.f58480i);
        }
    }

    /* renamed from: d.a.n0.f1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1386b implements View.OnClickListener {
        public View$OnClickListenerC1386b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58479h.onItemViewClick(b.this.f58474c, 101, 0, 0L, b.this.f58480i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f58479h.onItemViewLongClick(b.this.f58473b, 200, 0, 0L, b.this.f58480i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f58479h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f41953a.findViewById(R.id.root_view);
        this.f58473b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f58474c = headImageView;
        headImageView.setIsRound(false);
        this.f58475d = (TextView) this.f58473b.findViewById(R.id.tv_user_name);
        this.f58476e = (TextView) this.f58473b.findViewById(R.id.tv_group_name);
        this.f58477f = (TextView) this.f58473b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f58473b.findViewById(R.id.btn_pass);
        this.f58478g = textView;
        textView.setOnClickListener(new a());
        this.f58474c.setOnClickListener(new View$OnClickListenerC1386b());
        this.f58473b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.f58480i = validateItemData;
    }

    public void refresh() {
        if (this.f58480i == null) {
            return;
        }
        this.f58479h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58479h.getLayoutMode().j(this.f58473b);
        String portrait = this.f58480i.getPortrait();
        this.f58474c.setTag(portrait);
        this.f58474c.U(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f58480i.getUserName())) {
            this.f58475d.setText(this.f58480i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f58480i.getGroupName())) {
            TextView textView = this.f58476e;
            textView.setText(this.f58479h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f58480i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f58480i.getApplyReason())) {
            TextView textView2 = this.f58477f;
            textView2.setText(this.f58479h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f58480i.getApplyReason());
        }
        if (this.f58480i.isPass()) {
            this.f58478g.setEnabled(false);
            this.f58478g.setText(this.f58479h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f58478g, R.color.CAM_X0109);
            this.f58478g.setBackgroundDrawable(null);
        } else {
            this.f58478g.setEnabled(true);
            this.f58478g.setText(this.f58479h.getPageContext().getString(R.string.pass));
        }
        if (this.f58480i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f58473b, R.color.common_color_10178);
    }
}
