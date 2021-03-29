package d.b.i0.q1.h.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.b.h0.s.c.t;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f59594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f59595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f59596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f59597d;

        public a(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
            this.f59594a = editText;
            this.f59595b = spannableStringBuilder;
            this.f59596c = i;
            this.f59597d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                b.this.c(this.f59594a, this.f59595b, this.f59596c, aVar, this.f59597d);
            }
        }
    }

    public void b(BdBaseActivity<?> bdBaseActivity, EditText editText, t tVar) {
        if (((ImageSpan[]) editText.getText().getSpans(0, editText.getText().length(), ImageSpan.class)).length >= 10) {
            Toast.makeText(bdBaseActivity.getPageContext().getPageActivity(), R.string.too_many_face, 0).show();
            return;
        }
        String b2 = tVar.b();
        EmotionGroupType e2 = tVar.e();
        if (b2 != null) {
            d.b.b.e.l.d.h().k(b2, 20, new a(editText, new SpannableStringBuilder(b2), editText.getSelectionStart(), e2), 0, 0, bdBaseActivity.getUniqueId(), null, b2, Boolean.FALSE, null);
        }
    }

    public final void c(EditText editText, SpannableStringBuilder spannableStringBuilder, int i, d.b.b.j.d.a aVar, EmotionGroupType emotionGroupType) {
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
