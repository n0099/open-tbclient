package d.a.o0;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public abstract class i extends ClickableSpan {
    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        TbadkApplication inst = TbadkApplication.getInst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkApplication.getInst()");
        textPaint.setColor(inst.getResources().getColor(R.color.CAM_X0303));
    }
}
