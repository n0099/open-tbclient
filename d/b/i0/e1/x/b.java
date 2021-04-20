package d.b.i0.e1.x;

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
public class b extends d.b.c.a.c<ValidateActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f55598b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f55599c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55600d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55601e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55602f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55603g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f55604h;
    public ValidateItemData i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f55604h.onItemViewClick(b.this.f55603g, 100, 0, 0L, b.this.i);
        }
    }

    /* renamed from: d.b.i0.e1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1278b implements View.OnClickListener {
        public View$OnClickListenerC1278b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f55604h.onItemViewClick(b.this.f55599c, 101, 0, 0L, b.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f55604h.onItemViewLongClick(b.this.f55598b, 200, 0, 0L, b.this.i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f55604h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f41966a.findViewById(R.id.root_view);
        this.f55598b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f55599c = headImageView;
        headImageView.setIsRound(false);
        this.f55600d = (TextView) this.f55598b.findViewById(R.id.tv_user_name);
        this.f55601e = (TextView) this.f55598b.findViewById(R.id.tv_group_name);
        this.f55602f = (TextView) this.f55598b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f55598b.findViewById(R.id.btn_pass);
        this.f55603g = textView;
        textView.setOnClickListener(new a());
        this.f55599c.setOnClickListener(new View$OnClickListenerC1278b());
        this.f55598b.setOnLongClickListener(new c());
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
        this.f55604h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f55604h.getLayoutMode().j(this.f55598b);
        String portrait = this.i.getPortrait();
        this.f55599c.setTag(portrait);
        this.f55599c.W(portrait, 12, false);
        if (!TextUtils.isEmpty(this.i.getUserName())) {
            this.f55600d.setText(this.i.getUserName());
        }
        if (!TextUtils.isEmpty(this.i.getGroupName())) {
            TextView textView = this.f55601e;
            textView.setText(this.f55604h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.i.getApplyReason())) {
            TextView textView2 = this.f55602f;
            textView2.setText(this.f55604h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.i.getApplyReason());
        }
        if (this.i.isPass()) {
            this.f55603g.setEnabled(false);
            this.f55603g.setText(this.f55604h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f55603g, R.color.CAM_X0109);
            this.f55603g.setBackgroundDrawable(null);
        } else {
            this.f55603g.setEnabled(true);
            this.f55603g.setText(this.f55604h.getPageContext().getString(R.string.pass));
        }
        if (this.i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f55598b, R.color.common_color_10178);
    }
}
