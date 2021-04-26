package d.a.j0.k0;

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
import d.a.c.e.p.l;
import d.a.i0.s.c.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f56258a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56259a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56260b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f56261c;

        public a(EditText editText, Context context, v vVar) {
            this.f56259a = editText;
            this.f56260b = context;
            this.f56261c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null) {
                int selectionStart = this.f56259a.getSelectionStart();
                b.e(this.f56260b, this.f56259a, new SpannableStringBuilder(this.f56261c.b()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f56261c.e());
            }
        }
    }

    /* renamed from: d.a.j0.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1338b extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56262a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56263b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56264c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f56265d;

        public C1338b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f56262a = editText;
            this.f56263b = context;
            this.f56264c = spannableStringBuilder;
            this.f56265d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((C1338b) aVar, str, i2);
            if (aVar != null) {
                int selectionStart = this.f56262a.getSelectionStart();
                b.e(this.f56263b, this.f56262a, this.f56264c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f56265d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56268c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f56269d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f56270e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56266a = spannableStringBuilder;
            this.f56267b = i2;
            this.f56268c = i3;
            this.f56269d = iArr;
            this.f56270e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            f fVar;
            f fVar2;
            super.onLoaded((c) aVar, str, i2);
            if (aVar != null) {
                Bitmap p = aVar.p();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                int width = (int) (p.getWidth() * 0.5d);
                bitmapDrawable.setBounds(0, 0, width, width);
                bitmapDrawable.setGravity(119);
                this.f56266a.setSpan(new d.a.c.j.b(bitmapDrawable, 1), this.f56267b, this.f56268c, 33);
                int[] iArr = this.f56269d;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56270e) == null) {
                    return;
                }
                fVar2.a(this.f56266a);
                return;
            }
            this.f56266a.setSpan("", this.f56267b, this.f56268c, 33);
            int[] iArr2 = this.f56269d;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56270e) == null) {
                return;
            }
            fVar.a(this.f56266a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56272b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56273c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56274d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56276f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56271a = context;
            this.f56272b = spannableStringBuilder;
            this.f56273c = i2;
            this.f56274d = i3;
            this.f56275e = iArr;
            this.f56276f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((d) aVar, str, i2);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f56271a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56271a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56272b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56273c, this.f56274d, 33);
                int[] iArr = this.f56275e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56276f) == null) {
                    return;
                }
                fVar2.a(this.f56272b);
                return;
            }
            this.f56272b.setSpan("", this.f56273c, this.f56274d, 33);
            int[] iArr2 = this.f56275e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56276f) == null) {
                return;
            }
            fVar.a(this.f56272b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56279c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56280d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56282f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56277a = context;
            this.f56278b = spannableStringBuilder;
            this.f56279c = i2;
            this.f56280d = i3;
            this.f56281e = iArr;
            this.f56282f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((e) aVar, str, i2);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f56277a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56277a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56278b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56279c, this.f56280d, 33);
                int[] iArr = this.f56281e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56282f) == null) {
                    return;
                }
                fVar2.a(this.f56278b);
                return;
            }
            this.f56278b.setSpan("", this.f56279c, this.f56280d, 33);
            int[] iArr2 = this.f56281e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56282f) == null) {
                return;
            }
            fVar.a(this.f56278b);
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
            editText.onKeyDown(67, f56258a);
        }
        editText.onKeyDown(67, f56258a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, v vVar, EditText editText) {
        if (vVar == null || editText == null || vVar.b() == null) {
            return;
        }
        String b2 = vVar.b();
        EmotionGroupType e2 = vVar.e();
        if (e2 != EmotionGroupType.LOCAL && e2 != EmotionGroupType.USER_COLLECT && !b2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), b2);
        } else if (b2 != null) {
            d.a.c.e.l.d.h().k(b2, 20, new C1338b(editText, context, new SpannableStringBuilder(b2), e2), 0, 0, BdUniqueId.gen(), null, b2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, v vVar, EditText editText) {
        if (vVar == null || TextUtils.isEmpty(vVar.b()) || TextUtils.isEmpty(vVar.f()) || editText == null) {
            return;
        }
        editText.getText().toString();
        d.a.c.e.l.d.h().k(vVar.f(), 10, new a(editText, context, vVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, String str, f fVar) {
        String str2;
        CustomResponsedMessage runTask;
        if (context == null || TextUtils.isEmpty(str) || fVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int[] iArr = {d.a.j0.k0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.a.j0.k0.a.f56256a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                d.a.c.e.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, fVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
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
                d.a.c.e.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, fVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str2);
            if (split2 != null && split2.length == 6) {
                String str3 = str2;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, fVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    d.a.c.e.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str2 = str3;
            }
        }
    }

    public static void e(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, d.a.c.j.d.a aVar, EmotionGroupType emotionGroupType) {
        if (context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i3 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i3, i3);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.a.j0.k0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
