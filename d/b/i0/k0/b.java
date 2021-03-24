package d.b.i0.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.s.c.t;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f56420a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f56423c;

        public a(EditText editText, Context context, t tVar) {
            this.f56421a = editText;
            this.f56422b = context;
            this.f56423c = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                int selectionStart = this.f56421a.getSelectionStart();
                b.e(this.f56422b, this.f56421a, new SpannableStringBuilder(this.f56423c.b()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f56423c.e());
            }
        }
    }

    /* renamed from: d.b.i0.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1321b extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56426c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f56427d;

        public C1321b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f56424a = editText;
            this.f56425b = context;
            this.f56426c = spannableStringBuilder;
            this.f56427d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((C1321b) aVar, str, i);
            if (aVar != null) {
                int selectionStart = this.f56424a.getSelectionStart();
                b.e(this.f56425b, this.f56424a, this.f56426c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f56427d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56430c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f56431d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f56432e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56428a = spannableStringBuilder;
            this.f56429b = i;
            this.f56430c = i2;
            this.f56431d = iArr;
            this.f56432e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            f fVar;
            f fVar2;
            super.onLoaded((c) aVar, str, i);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                double width = p.getWidth();
                Double.isNaN(width);
                int i2 = (int) (width * 0.5d);
                bitmapDrawable.setBounds(0, 0, i2, i2);
                bitmapDrawable.setGravity(119);
                this.f56428a.setSpan(new d.b.b.j.b(bitmapDrawable, 1), this.f56429b, this.f56430c, 33);
                int[] iArr = this.f56431d;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56432e) == null) {
                    return;
                }
                fVar2.a(this.f56428a);
                return;
            }
            this.f56428a.setSpan("", this.f56429b, this.f56430c, 33);
            int[] iArr2 = this.f56431d;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56432e) == null) {
                return;
            }
            fVar.a(this.f56428a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56436d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56438f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56433a = context;
            this.f56434b = spannableStringBuilder;
            this.f56435c = i;
            this.f56436d = i2;
            this.f56437e = iArr;
            this.f56438f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            f fVar;
            f fVar2;
            super.onLoaded((d) aVar, str, i);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                int dimensionPixelSize = this.f56433a.getResources().getDimensionPixelSize(R.dimen.ds80);
                double width = p.getWidth();
                double d2 = dimensionPixelSize;
                Double.isNaN(d2);
                double height = p.getHeight();
                Double.isNaN(height);
                Double.isNaN(width);
                int i2 = (int) (width * ((d2 * 1.0d) / height));
                double k = l.k(this.f56433a);
                Double.isNaN(k);
                if (i2 > k * 0.6d) {
                    double width2 = p.getWidth();
                    Double.isNaN(width2);
                    i2 = (int) (width2 * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, i2, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56434b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56435c, this.f56436d, 33);
                int[] iArr = this.f56437e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56438f) == null) {
                    return;
                }
                fVar2.a(this.f56434b);
                return;
            }
            this.f56434b.setSpan("", this.f56435c, this.f56436d, 33);
            int[] iArr2 = this.f56437e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56438f) == null) {
                return;
            }
            fVar.a(this.f56434b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56439a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56441c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56442d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56444f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56439a = context;
            this.f56440b = spannableStringBuilder;
            this.f56441c = i;
            this.f56442d = i2;
            this.f56443e = iArr;
            this.f56444f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            f fVar;
            f fVar2;
            super.onLoaded((e) aVar, str, i);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                int dimensionPixelSize = this.f56439a.getResources().getDimensionPixelSize(R.dimen.ds80);
                double width = p.getWidth();
                double d2 = dimensionPixelSize;
                Double.isNaN(d2);
                double height = p.getHeight();
                Double.isNaN(height);
                Double.isNaN(width);
                int i2 = (int) (width * ((d2 * 1.0d) / height));
                double k = l.k(this.f56439a);
                Double.isNaN(k);
                if (i2 > k * 0.6d) {
                    double width2 = p.getWidth();
                    Double.isNaN(width2);
                    i2 = (int) (width2 * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, i2, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56440b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56441c, this.f56442d, 33);
                int[] iArr = this.f56443e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56444f) == null) {
                    return;
                }
                fVar2.a(this.f56440b);
                return;
            }
            this.f56440b.setSpan("", this.f56441c, this.f56442d, 33);
            int[] iArr2 = this.f56443e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56444f) == null) {
                return;
            }
            fVar.a(this.f56440b);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    public static void a(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, f56420a);
        }
        editText.onKeyDown(67, f56420a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, t tVar, EditText editText) {
        if (tVar == null || editText == null || tVar.b() == null) {
            return;
        }
        String b2 = tVar.b();
        EmotionGroupType e2 = tVar.e();
        if (e2 != EmotionGroupType.LOCAL && e2 != EmotionGroupType.USER_COLLECT && !b2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), b2);
        } else if (b2 != null) {
            d.b.b.e.l.d.h().k(b2, 20, new C1321b(editText, context, new SpannableStringBuilder(b2), e2), 0, 0, BdUniqueId.gen(), null, b2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, t tVar, EditText editText) {
        if (tVar == null || TextUtils.isEmpty(tVar.b()) || TextUtils.isEmpty(tVar.f()) || editText == null) {
            return;
        }
        editText.getText().toString();
        d.b.b.e.l.d.h().k(tVar.f(), 10, new a(editText, context, tVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, String str, f fVar) {
        String str2;
        CustomResponsedMessage runTask;
        if (context == null || TextUtils.isEmpty(str) || fVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int[] iArr = {d.b.i0.k0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.b.i0.k0.a.f56418a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                d.b.b.e.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, fVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (true) {
            str2 = ",";
            if (!matcher2.find()) {
                break;
            }
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5) {
                d.b.b.e.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, fVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str2);
            if (split2 != null && split2.length == 6) {
                String str3 = str2;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, fVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    d.b.b.e.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str2 = str3;
            }
        }
    }

    public static void e(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, d.b.b.j.d.a aVar, EmotionGroupType emotionGroupType) {
        if (context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            double d2 = width;
            Double.isNaN(d2);
            int i2 = (int) (d2 * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            double width2 = p.getWidth();
            double d3 = dimensionPixelSize;
            Double.isNaN(d3);
            double height = p.getHeight();
            Double.isNaN(height);
            Double.isNaN(width2);
            int i3 = (int) (width2 * ((d3 * 1.0d) / height));
            if (i3 > editText.getMeasuredWidth()) {
                double width3 = p.getWidth();
                Double.isNaN(width3);
                i3 = (int) (width3 * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, i3, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.b.i0.k0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i, spannableStringBuilder);
    }
}
