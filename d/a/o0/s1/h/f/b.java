package d.a.o0.s1.h.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.a.n0.s.c.v;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f64550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f64551b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f64552c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f64553d;

        public a(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, EmotionGroupType emotionGroupType) {
            this.f64550a = editText;
            this.f64551b = spannableStringBuilder;
            this.f64552c = i2;
            this.f64553d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                b.this.c(this.f64550a, this.f64551b, this.f64552c, aVar, this.f64553d);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, v vVar) {
        if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
            Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), R.string.too_many_face, 0).show();
            return;
        }
        String c2 = vVar.c();
        EmotionGroupType f2 = vVar.f();
        if (c2 != null) {
            d.a.c.e.l.d.h().k(c2, 20, new a(editText, new SpannableStringBuilder(c2), editText.getSelectionStart(), f2), 0, 0, bdBaseActivity.getUniqueId(), null, c2, Boolean.FALSE, null);
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, d.a.c.k.d.a aVar, EmotionGroupType emotionGroupType) {
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
