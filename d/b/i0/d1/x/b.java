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
/* loaded from: classes3.dex */
public class b extends d.b.b.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54076b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f54077c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54078d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54079e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54080f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54081g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f54082h;
    public ValidateItemData i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54082h.onItemViewClick(b.this.f54081g, 100, 0, 0L, b.this.i);
        }
    }

    /* renamed from: d.b.i0.d1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1215b implements View.OnClickListener {
        public View$OnClickListenerC1215b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f54082h.onItemViewClick(b.this.f54077c, 101, 0, 0L, b.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f54082h.onItemViewLongClick(b.this.f54076b, 200, 0, 0L, b.this.i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f54082h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f41469a.findViewById(R.id.root_view);
        this.f54076b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f54077c = headImageView;
        headImageView.setIsRound(false);
        this.f54078d = (TextView) this.f54076b.findViewById(R.id.tv_user_name);
        this.f54079e = (TextView) this.f54076b.findViewById(R.id.tv_group_name);
        this.f54080f = (TextView) this.f54076b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f54076b.findViewById(R.id.btn_pass);
        this.f54081g = textView;
        textView.setOnClickListener(new a());
        this.f54077c.setOnClickListener(new View$OnClickListenerC1215b());
        this.f54076b.setOnLongClickListener(new c());
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
        this.f54082h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f54082h.getLayoutMode().j(this.f54076b);
        String portrait = this.i.getPortrait();
        this.f54077c.setTag(portrait);
        this.f54077c.W(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.f54078d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.f54079e;
            textView.setText(this.f54082h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f54080f;
            textView2.setText(this.f54082h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.f54081g.setEnabled(false);
            this.f54081g.setText(this.f54082h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f54081g, R.color.CAM_X0109);
            this.f54081g.setBackgroundDrawable(null);
        } else {
            this.f54081g.setEnabled(true);
            this.f54081g.setText(this.f54082h.getPageContext().getString(R.string.pass));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f54076b, R.color.common_color_10178);
    }
}
