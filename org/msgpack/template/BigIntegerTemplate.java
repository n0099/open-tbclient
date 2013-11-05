package org.msgpack.template;

import java.math.BigInteger;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class BigIntegerTemplate extends AbstractTemplate<BigInteger> {

    /* renamed from: a  reason: collision with root package name */
    static final BigIntegerTemplate f2853a = new BigIntegerTemplate();

    private BigIntegerTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, BigInteger bigInteger, boolean z) {
        if (bigInteger == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(bigInteger);
    }

    public static BigIntegerTemplate a() {
        return f2853a;
    }
}
