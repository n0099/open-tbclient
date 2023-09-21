package com.bytedance.tools.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.nnb;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends c {
    public a(Context context, RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        super(context, radioGroup, nnbVar, list);
        setTitle("手动输入");
        setId(66666699);
    }

    @Override // com.bytedance.tools.ui.view.c
    public void b(RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        super.b(radioGroup, nnbVar, list);
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0560, this.d);
        EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091f4e);
        EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f091f4f);
        nnb nnbVar2 = this.e;
        if (nnbVar2 != null) {
            editText.setText(nnbVar2.a());
            editText2.setText(this.e.d());
        }
    }

    @Override // com.bytedance.tools.ui.view.c
    public boolean d() {
        String obj = ((EditText) findViewById(R.id.obfuscated_res_0x7f091f4e)).getText().toString();
        String obj2 = ((EditText) findViewById(R.id.obfuscated_res_0x7f091f4f)).getText().toString();
        if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2) && TextUtils.getTrimmedLength(obj) == 16 && TextUtils.getTrimmedLength(obj2) == 16) {
            return false;
        }
        return true;
    }

    public void e() {
        ((EditText) findViewById(R.id.obfuscated_res_0x7f091f4e)).getEditableText().clear();
        ((EditText) findViewById(R.id.obfuscated_res_0x7f091f4f)).getEditableText().clear();
    }

    @Override // com.bytedance.tools.ui.view.c
    public nnb getConfigModel() {
        nnb nnbVar = new nnb(((EditText) findViewById(R.id.obfuscated_res_0x7f091f4e)).getText().toString(), ((EditText) findViewById(R.id.obfuscated_res_0x7f091f4f)).getText().toString());
        this.e = nnbVar;
        return nnbVar;
    }
}
