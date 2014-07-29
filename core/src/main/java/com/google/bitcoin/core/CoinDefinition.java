package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Quebecoin";
    public static final String coinTicker = "QBC";
    public static final String coinURIScheme = "quebecoin";
    public static final String cryptsyMarketId = "26";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "6";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://http://cryptexplorer.com/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "QN1etbhZHGxWVAmXcRjDcWq54JhMchtdyr";  //donation QBC address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 1 day per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //576 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(42000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(100000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70020;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70010;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 56790;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 46790;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 58;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0xd3edcaf1;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1395522490L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (884876);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000948015ca05a2197f8f676476c9dbc11de07c87e1a46f2331ea10f33087d"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 26;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTXInBytes = "04ffff001d01044c554c615072657373652032322f4d61722f32303134204c65205175c3a96265632061206c6573206d6f79656e7320646520646576656e697220756e20706179732c207265636f6e6e61c3ae7420436f75696c6c617264";   // "LaPresse 22/Mar/2014 Le Québec a les moyens de devenir un pays, reconnaît Couillard"
    static public String genesisTXOutBytes = "41040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9ac";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.service-crypto.com",
            "qbcseed.service-crypto.com"
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - quebecoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xd3edcaf1;      //0xd3, 0xed, 0xca, 0xf1
    public static final String testnetGenesisHash = "00000480b7d253fa603971195bae6b4fa10c65126c26c44c648ac2b5fc3fecbb";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1395522495L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (184248);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)  //still to do
    public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(26, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
	if (height  < 25)
            nSubsidy = Utils.toNanoCoins(0, 0);  // 0 Reward blocks to allow DarkGravityWave to start before distributing QBC.
	if (height  < 49)
            nSubsidy = Utils.toNanoCoins(1, 0);  // 1 Hour timeframe with 1 QBC block reward to allow miners to set up and be more fair to all.
	if (height  < 73)
            nSubsidy = Utils.toNanoCoins(4, 0);  // 1 Hour timeframe with small block reward to allow miners to set up and be more fair to all.
	if (height  < 97)
            nSubsidy = Utils.toNanoCoins(13, 0);  // 1 Hour timeframe with half block reward to allow miners to set up and be more fair to all.


	// Subsidy is cut in half every 420480 blocks, which will occur approximately every 4 years
	nSubsidy.shiftRight(height / 420480);  //  Quebecoin: 420480 blocks in ~2 years

        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "04A9CFD81AF5D53310BE45E6326E706A542B1028DF85D2819D5DE496D8816C83129CE874FE5E3A23B03544BFF35458833779DAB7A6FF687525A4E23CA59F1E2B94";
    public static final String TESTNET_SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.quebecoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.quebecoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.quebecoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 5,   new Sha256Hash("00000abcc55a9231f53e7c3cc4de43720139097aa2a72916a0ad725765038916"));
        checkpoints.put( 405, new Sha256Hash("00000000010a5becc2de4e7af1f48209383924342ed7bbbc822a63df311dc72a"));
        checkpoints.put( 700, new Sha256Hash("0000000000d448d3f99ff853f56ebab921586e7b4de66dafdeeed0b4a4f75485"));
        checkpoints.put( 800, new Sha256Hash("0000000000c2d5be6c8eebc3f395db1f934773db0a882fb629f6a43568c56714"));

    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "DPHYTSm3f96dHRY3VG1vZAFC1QrEPkEQnt";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "QU1rjHbrdJonVUgjT7Mncw7PEyPv3fMPvaGXp9EHDs1uzdJ98hUZ";

}
