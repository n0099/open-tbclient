package d.a.k0.k0;

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
import d.a.j0.s.c.v;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f56965a = new KeyEvent(0, 67);

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56966a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f56968c;

        public a(EditText editText, Context context, v vVar) {
            this.f56966a = editText;
            this.f56967b = context;
            this.f56968c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null) {
                int selectionStart = this.f56966a.getSelectionStart();
                b.e(this.f56967b, this.f56966a, new SpannableStringBuilder(this.f56968c.b()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f56968c.e());
            }
        }
    }

    /* renamed from: d.a.k0.k0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1410b extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f56969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56970b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56971c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f56972d;

        public C1410b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            this.f56969a = editText;
            this.f56970b = context;
            this.f56971c = spannableStringBuilder;
            this.f56972d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((C1410b) aVar, str, i2);
            if (aVar != null) {
                int selectionStart = this.f56969a.getSelectionStart();
                b.e(this.f56970b, this.f56969a, this.f56971c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f56972d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f56974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56975c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f56976d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f56977e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56973a = spannableStringBuilder;
            this.f56974b = i2;
            this.f56975c = i3;
            this.f56976d = iArr;
            this.f56977e = fVar;
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
                this.f56973a.setSpan(new d.a.c.j.b(bitmapDrawable, 1), this.f56974b, this.f56975c, 33);
                int[] iArr = this.f56976d;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56977e) == null) {
                    return;
                }
                fVar2.a(this.f56973a);
                return;
            }
            this.f56973a.setSpan("", this.f56974b, this.f56975c, 33);
            int[] iArr2 = this.f56976d;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56977e) == null) {
                return;
            }
            fVar.a(this.f56973a);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56978a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56979b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56980c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56981d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56983f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56978a = context;
            this.f56979b = spannableStringBuilder;
            this.f56980c = i2;
            this.f56981d = i3;
            this.f56982e = iArr;
            this.f56983f = fVar;
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
                int dimensionPixelSize = this.f56978a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56978a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56979b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56980c, this.f56981d, 33);
                int[] iArr = this.f56982e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56983f) == null) {
                    return;
                }
                fVar2.a(this.f56979b);
                return;
            }
            this.f56979b.setSpan("", this.f56980c, this.f56981d, 33);
            int[] iArr2 = this.f56982e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56983f) == null) {
                return;
            }
            fVar.a(this.f56979b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f56984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f56985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56986c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f56987d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f56988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f56989f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            this.f56984a = context;
            this.f56985b = spannableStringBuilder;
            this.f56986c = i2;
            this.f56987d = i3;
            this.f56988e = iArr;
            this.f56989f = fVar;
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
                int dimensionPixelSize = this.f56984a.getResources().getDimensionPixelSize(R.dimen.ds80);
                int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                if (width > l.k(this.f56984a) * 0.6d) {
                    width = (int) (p.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                bitmapDrawable.setGravity(119);
                this.f56985b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f56986c, this.f56987d, 33);
                int[] iArr = this.f56988e;
                int i3 = iArr[0] - 1;
                iArr[0] = i3;
                if (i3 != 0 || (fVar2 = this.f56989f) == null) {
                    return;
                }
                fVar2.a(this.f56985b);
                return;
            }
            this.f56985b.setSpan("", this.f56986c, this.f56987d, 33);
            int[] iArr2 = this.f56988e;
            int i4 = iArr2[0] - 1;
            iArr2[0] = i4;
            if (i4 != 0 || (fVar = this.f56989f) == null) {
                return;
            }
            fVar.a(this.f56985b);
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
            editText.onKeyDown(67, f56965a);
        }
        editText.onKeyDown(67, f56965a);
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
            d.a.c.e.l.d.h().k(b2, 20, new C1410b(editText, context, new SpannableStringBuilder(b2), e2), 0, 0, BdUniqueId.gen(), null, b2, Boolean.FALSE, null);
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
        int[] iArr = {d.a.k0.k0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = d.a.k0.k0.a.f56963a.matcher(spannableStringBuilder);
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
        spannableStringBuilder.setSpan(new d.a.k0.k0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
