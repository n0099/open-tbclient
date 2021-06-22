package d.a.o0.f1.x;

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
    public View f58598b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f58599c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58600d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58601e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58602f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58603g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f58604h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f58605i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58604h.onItemViewClick(b.this.f58603g, 100, 0, 0L, b.this.f58605i);
        }
    }

    /* renamed from: d.a.o0.f1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1390b implements View.OnClickListener {
        public View$OnClickListenerC1390b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58604h.onItemViewClick(b.this.f58599c, 101, 0, 0L, b.this.f58605i);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            b.this.f58604h.onItemViewLongClick(b.this.f58598b, 200, 0, 0L, b.this.f58605i);
            return true;
        }
    }

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.f58604h = validateActivity;
        l();
    }

    public void l() {
        View findViewById = this.f42056a.findViewById(R.id.root_view);
        this.f58598b = findViewById;
        HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
        this.f58599c = headImageView;
        headImageView.setIsRound(false);
        this.f58600d = (TextView) this.f58598b.findViewById(R.id.tv_user_name);
        this.f58601e = (TextView) this.f58598b.findViewById(R.id.tv_group_name);
        this.f58602f = (TextView) this.f58598b.findViewById(R.id.tv_apply_reason);
        TextView textView = (TextView) this.f58598b.findViewById(R.id.btn_pass);
        this.f58603g = textView;
        textView.setOnClickListener(new a());
        this.f58599c.setOnClickListener(new View$OnClickListenerC1390b());
        this.f58598b.setOnLongClickListener(new c());
    }

    public void m(ValidateItemData validateItemData) {
        n(validateItemData);
        refresh();
    }

    public void n(ValidateItemData validateItemData) {
        this.f58605i = validateItemData;
    }

    public void refresh() {
        if (this.f58605i == null) {
            return;
        }
        this.f58604h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58604h.getLayoutMode().j(this.f58598b);
        String portrait = this.f58605i.getPortrait();
        this.f58599c.setTag(portrait);
        this.f58599c.U(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f58605i.getUserName())) {
            this.f58600d.setText(this.f58605i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f58605i.getGroupName())) {
            TextView textView = this.f58601e;
            textView.setText(this.f58604h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f58605i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f58605i.getApplyReason())) {
            TextView textView2 = this.f58602f;
            textView2.setText(this.f58604h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f58605i.getApplyReason());
        }
        if (this.f58605i.isPass()) {
            this.f58603g.setEnabled(false);
            this.f58603g.setText(this.f58604h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f58603g, R.color.CAM_X0109);
            this.f58603g.setBackgroundDrawable(null);
        } else {
            this.f58603g.setEnabled(true);
            this.f58603g.setText(this.f58604h.getPageContext().getString(R.string.pass));
        }
        if (this.f58605i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f58598b, R.color.common_color_10178);
    }
}
