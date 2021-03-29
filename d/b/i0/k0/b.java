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
    public static final KeyEvent f56421a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56422a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f56424c;

        public a(EditText editText, Context context, t tVar) {
            this.f56422a = editText;
            this.f56423b = context;
            this.f56424c = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar != null) {
                int selectionStart = this.f56422a.getSelectionStart();
                b.e(this.f56423b, this.f56422a, new SpannableStringBuilder(this.f56424c.b()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f56424c.e());
            }
        }
    }

    /* renamed from: d.b.i0.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1322b extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56425a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56427c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f56428d;

        public C1322b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f56425a = editText;
            this.f56426b = context;
            this.f56427c = spannableStringBuilder;
            this.f56428d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((C1322b) aVar, str, i);
            if (aVar != null) {
                int selectionStart = this.f56425a.getSelectionStart();
                b.e(this.f56426b, this.f56425a, this.f56427c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f56428d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56429a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56430b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56431c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f56432d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f56433e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56429a = spannableStringBuilder;
            this.f56430b = i;
            this.f56431c = i2;
            this.f56432d = iArr;
            this.f56433e = fVar;
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
                int width = (int) (p.getWidth() * 0.5d);
                bitmapDrawable.setBounds(0, 0, width, width);
                bitmapDrawable.setGravity(119);
                this.f56429a.setSpan(new d.b.b.j.b(bitmapDrawable, 1), this.f56430b, this.f56431c, 33);
                int[] iArr = this.f56432d;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f56433e) == null) {
                    return;
                }
                fVar2.a(this.f56429a);
                return;
            }
            this.f56429a.setSpan("", this.f56430b, this.f56431c, 33);
            int[] iArr2 = this.f56432d;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f56433e) == null) {
                return;
            }
            fVar.a(this.f56429a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56434a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56436c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56437d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56439f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56434a = context;
            this.f56435b = spannableStringBuilder;
            this.f56436c = i;
            this.f56437d = i2;
            this.f56438e = iArr;
            this.f56439f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((d) aVar, str, i);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f56434a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56434a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56435b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56436c, this.f56437d, 33);
                int[] iArr = this.f56438e;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f56439f) == null) {
                    return;
                }
                fVar2.a(this.f56435b);
                return;
            }
            this.f56435b.setSpan("", this.f56436c, this.f56437d, 33);
            int[] iArr2 = this.f56438e;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f56439f) == null) {
                return;
            }
            fVar.a(this.f56435b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56441b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56442c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56443d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56445f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, f fVar) {
            this.f56440a = context;
            this.f56441b = spannableStringBuilder;
            this.f56442c = i;
            this.f56443d = i2;
            this.f56444e = iArr;
            this.f56445f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            f fVar;
            Bitmap p;
            f fVar2;
            super.onLoaded((e) aVar, str, i);
            if (aVar != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                int dimensionPixelSize = this.f56440a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56440a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56441b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56442c, this.f56443d, 33);
                int[] iArr = this.f56444e;
                int i2 = iArr[0] - 1;
                iArr[0] = i2;
                if (i2 != 0 || (fVar2 = this.f56445f) == null) {
                    return;
                }
                fVar2.a(this.f56441b);
                return;
            }
            this.f56441b.setSpan("", this.f56442c, this.f56443d, 33);
            int[] iArr2 = this.f56444e;
            int i3 = iArr2[0] - 1;
            iArr2[0] = i3;
            if (i3 != 0 || (fVar = this.f56445f) == null) {
                return;
            }
            fVar.a(this.f56441b);
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
            editText.onKeyDown(67, f56421a);
        }
        editText.onKeyDown(67, f56421a);
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
            d.b.b.e.l.d.h().k(b2, 20, new C1322b(editText, context, new SpannableStringBuilder(b2), e2), 0, 0, BdUniqueId.gen(), null, b2, Boolean.FALSE, null);
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
        Matcher matcher = d.b.i0.k0.a.f56419a.matcher(spannableStringBuilder);
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
            int i2 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new d.b.i0.k0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i, spannableStringBuilder);
    }
}
