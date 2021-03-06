package org.spongycastle.pqc.jcajce.provider.test;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;


public class Sphincs256KeyPairGeneratorTest
    extends KeyPairGeneratorTest
{

    protected void setUp()
    {
        super.setUp();
    }

    public void testKeyFactory()
        throws Exception
    {
        kf = KeyFactory.getInstance("SPHINCS256", "BCPQC");
        kf = KeyFactory.getInstance(PQCObjectIdentifiers.newHope.getId(), "BCPQC");
    }

    public void testKeyPairEncoding()
        throws Exception
    {
        kf = KeyFactory.getInstance("SPHINCS256", "BCPQC");

        kpg = KeyPairGenerator.getInstance("SPHINCS256", "BCPQC");
        kpg.initialize(new SPHINCS256KeyGenParameterSpec(SPHINCS256KeyGenParameterSpec.SHA512_256), new SecureRandom());
        performKeyPairEncodingTest(kpg.generateKeyPair());
    }

}
