package d.a.k0.r1.h.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.a.j0.s.c.v;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f60611a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f60612b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60613c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f60614d;

        public a(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, EmotionGroupType emotionGroupType) {
            this.f60611a = editText;
            this.f60612b = spannableStringBuilder;
            this.f60613c = i2;
            this.f60614d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                b.this.c(this.f60611a, this.f60612b, this.f60613c, aVar, this.f60614d);
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
            d.a.c.e.l.d.h().k(b2, 20, new a(editText, new SpannableStringBuilder(b2), editText.getSelectionStart(), e2), 0, 0, bdBaseActivity.getUniqueId(), null, b2, Boolean.FALSE, null);
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, d.a.c.j.d.a aVar, EmotionGroupType emotionGroupType) {
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
