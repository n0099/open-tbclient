package com.yy.mobile.framework.revenuesdk.statistics.hiido;

import android.text.TextUtils;
import androidx.transition.Transition;
import d.r.b.a.a.m.c.c.f;
import d.r.b.a.a.m.c.d.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0016:\u0001\u0016B\t\b\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/StatisticsReport;", "Ljava/lang/Runnable;", "runnable", "", "doReport", "(Ljava/lang/Runnable;)V", "", "content", "(Ljava/lang/String;)V", "doReportSync", "", "isDebug", "init", "(Z)V", "()Z", "mDebug", "Z", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/http/HiidoStatisticsHttpUtil;", "mHiidoStatisticsHttpUtil", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/http/HiidoStatisticsHttpUtil;", "<init>", "()V", "Companion", "statistics_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class StatisticsReport {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.m.c.b.b f39065a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39066b;

    /* renamed from: e  reason: collision with root package name */
    public static final a f39064e = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f39062c = StatisticsReport.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static final Lazy f39063d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) StatisticsReport$Companion$instance$2.INSTANCE);

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f39067a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), Transition.MATCH_INSTANCE_STR, "getInstance()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/StatisticsReport;"))};

        public a() {
        }

        public final StatisticsReport a() {
            Lazy lazy = StatisticsReport.f39063d;
            a aVar = StatisticsReport.f39064e;
            KProperty kProperty = f39067a[0];
            return (StatisticsReport) lazy.getValue();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f39068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ StatisticsReport f39069f;

        public b(String str, StatisticsReport statisticsReport) {
            this.f39068e = str;
            this.f39069f = statisticsReport;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.r.b.a.a.m.c.b.b bVar = this.f39069f.f39065a;
            if (bVar != null) {
                bVar.g(this.f39068e);
            }
        }
    }

    public /* synthetic */ StatisticsReport(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void c(String str) {
        f a2;
        if (TextUtils.isEmpty(str)) {
            d.a(f39062c, "context is empty");
        } else if (str == null || (a2 = f.f67452f.a()) == null) {
        } else {
            a2.c(new b(str, this));
        }
    }

    public final boolean d() {
        return this.f39066b;
    }

    public StatisticsReport() {
        this.f39065a = new d.r.b.a.a.m.c.b.b();
    }
}
