package d.a.s0.v1.h.f;

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
import d.a.r0.s.c.v;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f68561a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f68562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f68563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f68564d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f68565e;

        public a(b bVar, EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, editText, spannableStringBuilder, Integer.valueOf(i2), emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68565e = bVar;
            this.f68561a = editText;
            this.f68562b = spannableStringBuilder;
            this.f68563c = i2;
            this.f68564d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    this.f68565e.c(this.f68561a, this.f68562b, this.f68563c, aVar, this.f68564d);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdBaseActivity, editText, vVar) == null) {
            if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
                Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), R.string.too_many_face, 0).show();
                return;
            }
            String c2 = vVar.c();
            EmotionGroupType f2 = vVar.f();
            if (c2 != null) {
                d.a.c.e.l.d.h().k(c2, 20, new a(this, editText, new SpannableStringBuilder(c2), editText.getSelectionStart(), f2), 0, 0, bdBaseActivity.getUniqueId(), null, c2, Boolean.FALSE, null);
            }
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, d.a.c.k.d.a aVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{editText, spannableStringBuilder, Integer.valueOf(i2), aVar, emotionGroupType}) == null) {
            Bitmap p = aVar.p();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            int width = p.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                width = (int) (width * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            editText.getText().insert(i2, spannableStringBuilder);
        }
    }
}
