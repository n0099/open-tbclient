package javassist.bytecode;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import javassist.bytecode.annotation.AnnotationMemberValue;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.ByteMemberValue;
import javassist.bytecode.annotation.CharMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.DoubleMemberValue;
import javassist.bytecode.annotation.EnumMemberValue;
import javassist.bytecode.annotation.FloatMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.LongMemberValue;
import javassist.bytecode.annotation.ShortMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    y f2975a;
    javassist.bytecode.annotation.a[][] b;
    javassist.bytecode.annotation.a[] c;
    javassist.bytecode.annotation.a d;
    javassist.bytecode.annotation.d e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(byte[] bArr, y yVar) {
        super(bArr);
        this.f2975a = yVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public javassist.bytecode.annotation.a[][] a() {
        d();
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public javassist.bytecode.annotation.a[] b() {
        e();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public javassist.bytecode.annotation.d c() {
        g(0);
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void a(int i, int i2) {
        javassist.bytecode.annotation.a[][] aVarArr = new javassist.bytecode.annotation.a[i];
        for (int i3 = 0; i3 < i; i3++) {
            i2 = d(i2);
            aVarArr[i3] = this.c;
        }
        this.b = aVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int b(int i, int i2) {
        javassist.bytecode.annotation.a[] aVarArr = new javassist.bytecode.annotation.a[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            i = e(i);
            aVarArr[i3] = this.d;
        }
        this.c = aVarArr;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int a(int i, int i2, int i3) {
        this.d = new javassist.bytecode.annotation.a(i2, this.f2975a);
        return super.a(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int c(int i, int i2) {
        int c = super.c(i, i2);
        this.d.a(i2, this.e);
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void d(int i, int i2) {
        javassist.bytecode.annotation.d stringMemberValue;
        y yVar = this.f2975a;
        switch (i) {
            case BDLocation.TypeOffLineLocation /* 66 */:
                stringMemberValue = new ByteMemberValue(i2, yVar);
                break;
            case BDLocation.TypeOffLineLocationFail /* 67 */:
                stringMemberValue = new CharMemberValue(i2, yVar);
                break;
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                stringMemberValue = new DoubleMemberValue(i2, yVar);
                break;
            case 70:
                stringMemberValue = new FloatMemberValue(i2, yVar);
                break;
            case 73:
                stringMemberValue = new IntegerMemberValue(i2, yVar);
                break;
            case 74:
                stringMemberValue = new LongMemberValue(i2, yVar);
                break;
            case 83:
                stringMemberValue = new ShortMemberValue(i2, yVar);
                break;
            case 90:
                stringMemberValue = new BooleanMemberValue(i2, yVar);
                break;
            case SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE /* 115 */:
                stringMemberValue = new StringMemberValue(i2, yVar);
                break;
            default:
                throw new RuntimeException("unknown tag:" + i);
        }
        this.e = stringMemberValue;
        super.d(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void b(int i, int i2, int i3) {
        this.e = new EnumMemberValue(i2, i3, this.f2975a);
        super.b(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void e(int i, int i2) {
        this.e = new ClassMemberValue(i2, this.f2975a);
        super.e(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int a(int i) {
        javassist.bytecode.annotation.a aVar = this.d;
        int a2 = super.a(i);
        this.e = new AnnotationMemberValue(this.d, this.f2975a);
        this.d = aVar;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int f(int i, int i2) {
        ArrayMemberValue arrayMemberValue = new ArrayMemberValue(this.f2975a);
        javassist.bytecode.annotation.d[] dVarArr = new javassist.bytecode.annotation.d[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            i = g(i);
            dVarArr[i3] = this.e;
        }
        arrayMemberValue.a(dVarArr);
        this.e = arrayMemberValue;
        return i;
    }
}
