package org.acra.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface a {
    int A() default 0;

    int B() default 0;

    int C() default 0;

    String D() default "";

    int E() default 5000;

    boolean F() default false;

    boolean G() default true;

    String[] H() default {};

    String I() default "";

    int J() default 100;

    String K() default "https://docs.google.com/spreadsheet/formResponse?formkey=%s&ifq";

    boolean L() default false;

    String[] a() default {};

    String[] b() default {};

    int c() default 3000;

    ReportField[] d() default {};

    boolean e() default true;

    boolean f() default true;

    int g() default 5;

    boolean h() default false;

    String i();

    String j() default "";

    String k() default "ACRA-NULL-STRING";

    String l() default "ACRA-NULL-STRING";

    boolean m() default false;

    String[] n() default {"-t", "100", "-v", "time"};

    String o() default "";

    int p() default 3;

    ReportingInteractionMode q() default ReportingInteractionMode.SILENT;

    int r() default 0;

    int s() default 0;

    int t() default 17301543;

    int u() default 0;

    int v() default 0;

    int w() default 0;

    int x() default 17301624;

    int y() default 0;

    int z() default 0;
}
