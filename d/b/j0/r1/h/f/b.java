package d.b.j0.r1.h.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.b.i0.s.c.v;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f61709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f61710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f61711c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f61712d;

        public a(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
            this.f61709a = editText;
            this.f61710b = spannableStringBuilder;
            this.f61711c = i;
            this.f61712d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                b.this.c(this.f61709a, this.f61710b, this.f61711c, aVar, this.f61712d);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, v vVar) {
        if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
            Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), R.string.too_many_face, 0).show();
            return;
        }
        String b2 = vVar.b();
        EmotionGroupType e2 = vVar.e();
        if (b2 != null) {
            d.b.c.e.l.d.h().k(b2, 20, new a(editText, new SpannableStringBuilder(b2), editText.getSelectionStart(), e2), 0, 0, bdBaseActivity.getUniqueId(), null, b2, Boolean.FALSE, null);
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, d.b.c.j.d.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap p = aVar.p();
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
