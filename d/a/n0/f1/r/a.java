package d.a.n0.f1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import d.a.c.a.d;
/* loaded from: classes4.dex */
public class a extends d<AddGroupActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f54685a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54686b;

    /* renamed from: c  reason: collision with root package name */
    public View f54687c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f54688d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f54689e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54690f;

    /* renamed from: g  reason: collision with root package name */
    public View f54691g;

    /* renamed from: h  reason: collision with root package name */
    public View f54692h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f54693i;

    /* renamed from: d.a.n0.f1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1324a implements TextWatcher {
        public C1324a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f54691g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (a.this.f54688d.length() > 0) {
                a.this.f54689e.setVisibility(0);
            } else {
                a.this.f54689e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f54685a = null;
        this.f54686b = null;
        this.f54687c = null;
        this.f54688d = null;
        this.f54689e = null;
        this.f54690f = null;
        this.f54691g = null;
        this.f54693i = null;
        this.f54693i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        this.f54693i.getLayoutMode().k(i2 == 1);
        this.f54693i.getLayoutMode().j(this.f54685a);
        this.f54686b.onChangeSkinType(this.f54693i.getPageContext(), i2);
    }

    public void h() {
        EditText editText = this.f54688d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public final void initUI() {
        this.f54693i.setContentView(R.layout.im_add_group_activity);
        this.f54685a = this.f54693i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.f54693i.findViewById(R.id.addgroup_navigationbar);
        this.f54686b = navigationBar;
        this.f54687c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54686b.setTitleText(this.f54693i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.f54693i.findViewById(R.id.addgroup_input);
        this.f54688d = editText;
        editText.setInputType(2);
        this.f54689e = (ImageButton) this.f54693i.findViewById(R.id.addgroup_delbtn);
        this.f54691g = this.f54693i.findViewById(R.id.addgroup_searchbutton);
        this.f54692h = this.f54693i.findViewById(R.id.addgroup_vcode);
        this.f54688d.addTextChangedListener(new C1324a());
        this.f54691g = this.f54693i.findViewById(R.id.addgroup_searchbutton);
        this.f54690f = (ProgressBar) this.f54693i.findViewById(R.id.addgroup_progress);
        this.f54687c.setOnClickListener(this.f54693i);
        this.f54689e.setOnClickListener(this.f54693i);
        this.f54691g.setOnClickListener(this.f54693i);
        this.f54692h.setOnClickListener(this.f54693i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f54692h.setVisibility(8);
    }

    public View j() {
        return this.f54687c;
    }

    public View k() {
        return this.f54689e;
    }

    public View l() {
        return this.f54691g;
    }

    public View m() {
        return this.f54692h;
    }

    public void n(boolean z) {
        this.f54690f.setVisibility(z ? 0 : 8);
    }
}
