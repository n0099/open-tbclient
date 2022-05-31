package com.repackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ti7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends eg<um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ EmotionGroupType d;
        public final /* synthetic */ ti7 e;

        public a(ti7 ti7Var, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti7Var, editText, spannableStringBuilder, Integer.valueOf(i), emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ti7Var;
            this.a = editText;
            this.b = spannableStringBuilder;
            this.c = i;
            this.d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, umVar, str, i) == null) {
                super.onLoaded((a) umVar, str, i);
                if (umVar != null) {
                    this.e.c(this.a, this.b, this.c, umVar, this.d);
                }
            }
        }
    }

    public ti7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, cw4 cw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdBaseActivity, editText, cw4Var) == null) {
            if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
                Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f143d, 0).show();
                return;
            }
            String d = cw4Var.d();
            EmotionGroupType type = cw4Var.getType();
            if (d != null) {
                fg.h().k(d, 20, new a(this, editText, new SpannableStringBuilder(d), editText.getSelectionStart(), type), 0, 0, bdBaseActivity.getUniqueId(), null, d, Boolean.FALSE, null);
            }
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, um umVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{editText, spannableStringBuilder, Integer.valueOf(i), umVar, emotionGroupType}) == null) {
            Bitmap p = umVar.p();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            int width = p.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (width * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            editText.getText().insert(i, spannableStringBuilder);
        }
    }
}
