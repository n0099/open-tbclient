package com.bytedance.tools.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.vlb;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends c {
    public a(Context context, RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        super(context, radioGroup, vlbVar, list);
        setTitle("手动输入");
        setId(66666699);
    }

    @Override // com.bytedance.tools.ui.view.c
    public void b(RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        super.b(radioGroup, vlbVar, list);
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d055e, this.d);
        EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091f85);
        EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f091f86);
        vlb vlbVar2 = this.e;
        if (vlbVar2 != null) {
            editText.setText(vlbVar2.a());
            editText2.setText(this.e.d());
        }
    }

    @Override // com.bytedance.tools.ui.view.c
    public boolean d() {
        String obj = ((EditText) findViewById(R.id.obfuscated_res_0x7f091f85)).getText().toString();
        String obj2 = ((EditText) findViewById(R.id.obfuscated_res_0x7f091f86)).getText().toString();
        if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2) && TextUtils.getTrimmedLength(obj) == 16 && TextUtils.getTrimmedLength(obj2) == 16) {
            return false;
        }
        return true;
    }

    public void e() {
        ((EditText) findViewById(R.id.obfuscated_res_0x7f091f85)).getEditableText().clear();
        ((EditText) findViewById(R.id.obfuscated_res_0x7f091f86)).getEditableText().clear();
    }

    @Override // com.bytedance.tools.ui.view.c
    public vlb getConfigModel() {
        vlb vlbVar = new vlb(((EditText) findViewById(R.id.obfuscated_res_0x7f091f85)).getText().toString(), ((EditText) findViewById(R.id.obfuscated_res_0x7f091f86)).getText().toString());
        this.e = vlbVar;
        return vlbVar;
    }
}
